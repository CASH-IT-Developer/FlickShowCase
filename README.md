# FlickShowCase
[![](https://jitpack.io/v/CASH-IT-Developer/FlickShowCase.svg)](https://jitpack.io/#CASH-IT-Developer/FlickShowCase)
![alt text](https://raw.githubusercontent.com/CASH-IT-Developer/FlickShowCase/main/ss1.jpeg)

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
   
       // enabling data binding how to use this library
       
       dataBinding {
               enabled = true
           }
    
    dependencies {
        ...
        ...
        implementation 'com.github.CASH-IT-Developer:FlickShowCase:Tag'
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
                     .showing(this@MainActivity, 100)
             }
     
     
         }
     }
     
     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
             super.onActivityResult(requestCode, resultCode, data)
             if(resultCode == RESULT_OK && requestCode == 100){
                 showToast("Tooltip ok")
             }
         }

