package com.springboot.productmanagement.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "instagram_profile",createIndex = false)
public class InstagramProfile {
    @Id
    private String id;

    @Field(type = FieldType.Keyword, name = "username")
    private String username;

    @Field(type = FieldType.Text, name = "fullName")
    private String fullName;

    @Field(type = FieldType.Long, name = "followerCount")
    private Long followerCount;

    @Field(type = FieldType.Long, name = "followingCount")
    private Long followingCount;

    @Field(type = FieldType.Text, name = "biography")
    private String biography;

    @Field(type = FieldType.Keyword, name = "category")
    private String category;
}

