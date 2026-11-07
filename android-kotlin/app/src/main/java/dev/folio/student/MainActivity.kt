package dev.folio.student
import android.app.Activity
import android.os.Bundle
import android.graphics.Typeface
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.coroutines.*
class MainActivity:Activity(){
 private val scope=CoroutineScope(SupervisorJob()+Dispatchers.Main)
 // Android emulator host loopback is 10.0.2.2.
 private val api=LibraryApi.create("http://10.0.2.2:8080/")
 override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState)
  val root=LinearLayout(this).apply{orientation=LinearLayout.VERTICAL;setPadding(32,52,32,24);setBackgroundColor(0xFFF7F8F4.toInt())}
  val title=TextView(this).apply{text="folio.";textSize=32f;setTextColor(0xFF18332B.toInt());typeface=Typeface.DEFAULT_BOLD}
  val caption=TextView(this).apply{text="YOUR LIBRARY, REIMAGINED";textSize=11f;setPadding(0,8,0,24)}
  val body=TextView(this).apply{text="Connecting to your library…";textSize=15f}
  root.addView(title);root.addView(caption);root.addView(body);setContentView(root)
  scope.launch{try{val items=withContext(Dispatchers.IO){api.books()};body.text=items.joinToString("\n\n"){it.title+"\n"+it.author+" · "+if(it.available)"Available" else "On loan"}}catch(e:Exception){body.text="Cannot reach Folio API. Start Java backend.\n"+(e.message?:"Network error")}}
 }
 override fun onDestroy(){super.onDestroy();scope.cancel()}
}