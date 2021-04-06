# FlickShowCase

![alt text](https://raw.githubusercontent.com/vickyKDV/FloatingButtonDrag/master/mygif.gif)

   How to implementation
   
   
   add in build.gradle application
   
     allprojects {
          repositories {
             ...
             ...
             maven { url "https://jitpack.io" }

          }
      }
    
   add in build.gradle module
    
    dependencies {
        ...
        ...
        implementation 'com.github.vickykdv:FloatingButtonDrag:1.0'
    }
    
    
  Usage this library
  
     class MainActivity : AppCompatActivity() {
         override fun onCreate(savedInstanceState: Bundle?) {
             super.onCreate(savedInstanceState)
             setContentView(R.layout.activity_main)
     
             val buttonTop = findViewById<Button>(R.id.button)
     
             buttonTop.setOnClickListener {
                 FlickShowCase.Create()
                     .view(buttonTop)
                     .titleText("Title For Top!")
                     .descriptionText("Simple, short description for top tooltip.")
                     .buttonText("Tutup")
                     .showOkeButton(true)
                     .cancellableFromOutsideTouch(false)
                     .arrowPosition(ArrowPosition.TOP)
                     .highlightType(HighlightType.NONE)
                     .windowBackgroundAlpha(90)
                     .created()
                     .showing(this@MainActivity, 0)
             }
     
     
         }
     }

