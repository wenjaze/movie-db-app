# TheMovieDB App
__*This is a documentation of what i've learnt during this trial project*__

## Excercises:
* [x] __Swap 2 Activities on button click:__
 * [_Basics of Android Studio_](https://developer.android.com/training/basics/firstapp)
 * [_Naming Conventions_](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md)
 * _Commit messages_ [_(bonus)_](https://gitmoji.carloscuesta.me/)
 * [_Factory Pattern_](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm)
 * [_Prevent Wildcard imports_](https://stackoverflow.com/a/32907163/6694770)
 * [_Kotlin_](https://developer.android.com/courses/topics/android-basics-kotlin)
 * [_Layouts_](https://developer.android.com/guide/topics/ui/declaring-layout)
 * _values folder_ (_dimens.xml, styles.xml, colors.xml, strings.xml_)
 * [**_Activity Lifecycle:bangbang:_**](https://developer.android.com/reference/android/app/Activity#ActivityLifecycle)

* [x] __Swap 2 Fragments on button click:__
 *  [_return vs expression body_](https://discuss.kotlinlang.org/t/return-vs-expression-body/12485) 
 * [_Null safety_](https://kotlinlang.org/docs/reference/null-safety.html)
 * [_Import Scheme  (settings / code style / kotlin / import scheme / android studio)_](scheme.xml)
 * [**_Fragments Lifecycle:bangbang:_**](https://developer.android.com/guide/components/fragments#Lifecycle)
 * [_onClickListener_](https://developer.android.com/reference/kotlin/android/view/View.OnClickListener)
* [x] __Create a RecyclerView, on listelement click, navigate to SecondFragment__
 * [_RecyclerView Basics_](https://developer.android.com/guide/topics/ui/layout/recyclerview)
 * [_Also this_](https://guides.codepath.com/android/using-the-recyclerview)
 * [_Data Classes_](https://kotlinlang.org/docs/reference/data-classes.html)
* [x] __Implement inputField + searchButton on SearchFragment, Introduction to Debouncing__
 * [_Debouncing_](https://stackoverflow.com/questions/12142021/how-can-i-do-something-0-5-second-after-text-changed-in-my-edittext)
 * [_Icons_](https://material.io/resources/icons/?style=baseline)
 * _Handling Icons_:
  	* [_Screendenstiy_](https://developer.android.com/training/multiscreen/screendensities)
  	* [_Vectors_](https://developer.android.com/studio/write/vector-asset-studio)
  	* [_Convert to Webp_](https://developer.android.com/studio/write/convert-webp)
* [x] __Create a .json file and parse it into Kotlin objects (adapt it to RecyclerView, on background thread)__
 * [_JSON_](https://en.wikipedia.org/wiki/JSON)
 * [_also JSON_](https://www.w3schools.com/js/js_json_intro.asp)
 * [_JSON validator & formatter_](https://jsonformatter.curiousconcept.com/)
 * [_Moshi_](https://github.com/square/moshi)
 * [_A couple of cases :zany_face:_](https://medium.com/better-programming/string-case-styles-camel-pascal-snake-and-kebab-case-981407998841)
 * [_Threading_](https://blog.mindorks.com/android-core-looper-handler-and-handlerthread-bd54d69fe91a)
  * [_Message Queue_](https://medium.com/better-programming/a-detailed-story-about-handler-thread-looper-message-queue-ac2cd9be0d78)
  * [_Communicate UI_](https://developer.android.com/training/multiple-threads/communicate-ui)
 * [_S*O*L*I*D*_](https://www.letscode.hu/2016/04/26/tiszta-kod-5-resz-a-s-o-l-i-d-alapelvek/)
* [x] __HTTP request to TheMovieDB API, Adaptation to RecyclerView and SecondFragment__
 * [_HTTP_](https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview)
 * [_REST API_](https://www.sitepoint.com/developers-rest-api/)
 * [_OKHTTP_](https://square.github.io/okhttp/)
 * [_Retrofit_](https://square.github.io/retrofit/)
 * [_Api docs of search/movies_](https://developers.themoviedb.org/3/search/search-movies)


## TODO:
* [ ] __remove__:
 * [ ] white_bg_item
 * [ ] Movie.kt unused vars
 * [ ] Empty block : {}
* [ ] __fix__:
 * [ ] Movie.kt camelCases
 * [ ] onMovieItemClick -> OnMovieItemClick
 * [ ] SecondFragment TextViews formatting
  - (2 separate TV. label -> resources)
 * [ ] baseUrl -> build.config -> build.gradle
 * [ ] timerSchedule 500L -> companion obj.
