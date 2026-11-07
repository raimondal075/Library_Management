package dev.folio.student
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
data class BookDto(val id:Long,val title:String,val author:String,val category:String,val description:String,val available:Boolean)
data class LoanDto(val id:Long,val bookId:Long,val studentId:String,val borrowedOn:String,val dueOn:String,val returnedOn:String?)
data class LoanResponse(val active:List<LoanDto>,val history:List<LoanDto>)
interface LibraryApi {
 @GET("api/books") suspend fun books():List<BookDto>
 @GET("api/loans/{studentId}") suspend fun loans(@Path("studentId") studentId:String):LoanResponse
 companion object { fun create(url:String):LibraryApi=Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build().create(LibraryApi::class.java) }
}