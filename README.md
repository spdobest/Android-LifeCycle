# Android-LifeCycle
In this repository , i will explain the life cycle of each component and its state going through the states.


## ACTIVITY  
'Activity' is one of the main component in android application development. It have lots of in built methods which are known as lifecycle methods. Let me explain the lifecycle methods.  
 ### Activity Lifecycle Detail Diagram
 ![alt tag](https://github.com/spdobest/Android-LifeCycle/blob/master/app/images/activity_lifecycle.png)
   
 ####  Lifecycle Of Activity When Starts    
 onCreate() , OnStart() , OnResume()    
 ####  Lifecycle Of Activity When goes in background state      
 onPause(), onSavedInstanceState(),onStop()  
 ####  Lifecycle Of Activity when come from background to foreground      
 onRestart(), onStart(),onResume  
 ####  Lifecycle Of Activity and Fragment when Screen Rotate  
 onCreate(), onStart(), onRestoreInstanceState(), onResume()  
 Fragments - onAttach(),onCreate(), onCreateView(),onStart(),onResume()  
 #### Activity Lifecycle when crash occurs in onResume Method  
 It will not call any method, it will exit.  
 #### Fragment lifecycle when come to background  
 onPause(), onStop()
 #### Fragment Lifecycle when fragment comes from background to foreground
 onStart() , onResume()  
 #### Combined activity and fragment life cycle  
 onCreate(Activity) 
 onAttach(Fragment)
 onCreate(Fragment)
 onCreateView(Fragment)
 onViewCreated(Fragment)
 onStart(Fragment)
 onStart(Activity)
   
 ## FRAGMENT  
'Fragment' is a piece of an activity which enable more modular activity design. It will not be wrong if we say, a fragment is a kind of sub-activity.
 ###  Fragment Lifecycle Detailed Diagram
 ![alt tag](https://github.com/spdobest/Android-LifeCycle/blob/master/app/images/fragmentlifecycle_with_activity.jpg)  
 
