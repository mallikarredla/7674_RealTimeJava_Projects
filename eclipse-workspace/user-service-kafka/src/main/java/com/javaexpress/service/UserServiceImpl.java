package com.javaexpress.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.javaexpress.dto.UserDto;
import com.javaexpress.helper.UserMappingHelper;
import com.javaexpress.model.User;
import com.javaexpress.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;

    @Value("${kafka.topicname}")
    private String kafkaTopicName;

    @Override
    public UserDto save(UserDto userDto) {
        // Save user entity in DB
        User user = UserMappingHelper.map(userDto);
        User dbUser = userRepository.save(user);
        UserDto result = UserMappingHelper.map(dbUser);

        // Send message to Kafka topic
        ListenableFuture<SendResult<String, UserDto>> future = (ListenableFuture<SendResult<String, UserDto>>) kafkaTemplate.send(kafkaTopicName, result);

        // Add callback for success/failure
        future.addCallback(new ListenableFutureCallback<SendResult<String, UserDto>>() {
            @Override
            public void onSuccess(SendResult<String, UserDto> sendResult) {
                log.info("Message sent successfully to topic '{}' partition {} at offset {}",
                        sendResult.getRecordMetadata().topic(),
                        sendResult.getRecordMetadata().partition(),
                        sendResult.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Failed to send message to topic '{}'", kafkaTopicName, ex);
            }
        });

        return result;
    }

    @Override
    public UserDto findById(Integer userId) {
        return userRepository.findById(userId)
                .map(UserMappingHelper::map)
                .orElseThrow(() -> new RuntimeException("User not found in Database"));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .sorted(Comparator.comparing(User::getUserId))
                .map(UserMappingHelper::map)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto update(Integer userId, UserDto userDto) {
        // Implement update logic if needed
        return null;
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto findByUserUserName(String userName) {
        // Implement findByUserUserName logic if needed
        return null;
    }
}
