# Instagram Profile Management System

## Overview

This project is an Instagram Profile Management System that uses Spring Boot and Elasticsearch to store, search, and manage Instagram profiles.

## 1. InstagramProfile Entity Class

### Purpose:

This class represents Instagram profiles.

### Explanation:

The @Document annotation is used to create an Elasticsearch index named instagram_profile.

Each profile has a unique ID, marked with the @Id annotation.

The @Field annotation specifies different profile fields such as username, fullName, followerCount, etc.

Each field type is defined according to the Elasticsearch format (e.g., FieldType.Keyword, FieldType.Text).

## 2. InstagramProfileRepo Interface

### Purpose:

This interface acts as an Elasticsearch repository for InstagramProfile entity, allowing CRUD operations.

### Explanation:

This interface extends ElasticsearchRepository, which provides basic CRUD operations.

### Methods:

findByUsername: Fetches profiles based on the username.

findByCategory: Fetches profiles based on the category.

findByFollowerCountBetween: Fetches profiles within a given follower count range.

findAllCategories: Runs a custom query to fetch distinct categories.

## 3. InstagramProfileService Class

### Purpose:

This class handles business logic and processes data through the repository.

### Explanation:

fetchProfilesByFollowerCount: Fetches profiles within a given follower count range.

fetchProfilesByUsername: Fetches profiles page-wise based on the username.

fetchProfileByCategory: Fetches profiles based on the category and sorts them page-wise.

saveAllProfiles: Saves multiple Instagram profiles.

fetchAllCategories: Fetches all distinct categories and converts them into a list.

## 4. InstagramProfileController Class

### Purpose:

This controller class exposes REST APIs for users to fetch and save data.

### Explanation:

searchByFollowersCount: API to search Instagram profiles based on follower count range.

searchByUsername: API to search Instagram profiles by username.

searchByCategory: API to search profiles by category.

saveProfiles: API to save multiple Instagram profiles via a POST request.

getAllCategories: API to fetch all distinct categories.

## Summary of What and How

### What:

This project is an Instagram Profile Management System that uses Elasticsearch to store and search profile data.

Users can search profiles via APIs based on follower count, username, and category.

APIs are available to save multiple profiles and fetch categories.

### How:

The InstagramProfile entity class defines all profile attributes using Elasticsearch annotations.

The repository interacts with Elasticsearch to fetch and store data.

Business logic is implemented in the Service layer.

REST APIs are created in the Controller layer for client interaction.

## Technologies Used

Java

Spring Boot

Spring Data Elasticsearch

Postman (for API testing)

Maven

### API Endpoints

HTTP Method

Endpoint

### Description

GET

/api/profiles/search/followers_count?min=100&max=500

Search profiles based on a follower count range.

GET

/api/profiles/search/usernames?username=johndoe

Search profiles by username.

GET

/api/profiles/search/category?category=artist

Search profiles by category.

POST

/api/profiles/save-all

Save multiple profiles.

GET

/api/profiles/categories/list

Fetch all available categories.

## Conclusion

This project efficiently manages Instagram profiles and provides powerful search functionalities using Spring Boot and Elasticsearch.


