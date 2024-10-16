# Cat & Bird Pictures Project
I was successfully able to complete all the milestones of the project.

The app implements the following things: 
* A grid view to see random pictures. Ideally should have been just cats and birds. However, PicSum doesn't provide a way to filter the image categories.
* On clicking the picture, the selected picture is highlighted in green and its enlarged view is shown on top.
* To enlarge and highlight a different picture, simply click on it from the grid.
* Clicking the heart icon for any picture will add it to the favorites list
* All favorited images can be seen on teh Favorites Screen (that is accessible from the bottom navigation bar)
* Images can be favorited or de-favorited from both Home or Favorites screen. The data will be synced between the two screens.

## Design Decisions
* Used `strings.xml` to store string resources
* Used a Singleton design pattern for the Retrofit Client since it can only be instantiated once in the entire project
* Created separate composables for every component possible such as `HomeScreen()`, `FavoritesScreen()`, `PicSumImageGrid()`, `EnlargedImage()`, etc for modularity and reusability within the codebase.

## Troubleshooting
* When I initially cloned the repository, I was running into the following error due to old dependency versions.
```bash
* Execution failed for task ':app:extractIncludeDebugProto'.
> Could not determine the dependencies of null.
   > Could not resolve all task dependencies for configuration ':app:debugCompileClasspath'.
      > Could not find com.xwray:groupie:2.9.0.
        Required by:
            project :app
      > Could not find com.xwray:groupie-viewbinding:2.9.0.
        Required by:
            project :app
```
I found a solution here: https://github.com/lisawray/groupie/issues/384#issuecomment-836240103