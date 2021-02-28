# Flixter App
Flixter App is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

---

## Features
- [X] User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.
- [X] Views should be responsive for both landscape/portrait mode.
   - [X] In portrait mode, the poster image, title, and movie overview is shown.
   - [X] In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.
- [X] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [X] Improved the user interface by experimenting with styling and coloring.
- [X] For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.
- [X] Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [X] Allow video posts to be played in full-screen using the YouTubePlayerView.
- [X] Trailers for popular movies are played automatically when the movie is selected.
  - [X] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [X] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.


### App Walkthough GIF

![demoport](https://user-images.githubusercontent.com/63178444/107156729-0d833400-694e-11eb-84d5-cea3e4f42fd3.gif)

![demopart2](https://user-images.githubusercontent.com/63178444/108300468-5c12a880-716e-11eb-9678-79118e210541.gif)


### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids


## License

    Copyright [2021] [Haroon Ali Syed]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

