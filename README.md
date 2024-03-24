# Description
The BlogPost app is an Android application developed in Kotlin, allowing users to interact with a blogging platform. Using the Retrofit library, users can read, create, update, and delete blog posts through a RESTful API. The app provides feedback on the status of these operations, indicating success or failure.

# Features
# View Blog Posts:
> See a list of blog posts with titles and summaries.
> Tap on a post to view the full content.

# Update Post:
> Users can update existing blog posts.
> Implement both PUT and PATCH methods for full and partial updates.
> See status messages indicating whether the update was successful or failed.

# Delete Post:
> Delete unwanted blog posts.
> Confirmation dialog ensures the user intends to delete the post.

# Status Messages:
Clear status messages for each operation:
Successful post creation.
Successful post update.
Failed post update (with error message).
Successful post deletion.
Failed post deletion (with an error message).

# Error Handling:
Handle network errors gracefully, displaying appropriate messages.
Display user-friendly messages for API errors.

# Technologies Used:
Kotlin
Retrofit for API calls
JSON Parsing with Gson
Dialogs for user interaction
