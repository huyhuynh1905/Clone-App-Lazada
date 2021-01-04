
<h1 align="center">Ứng Dụng Lazada</h1>

Ứng dụng App Lazada: 
<div align="center"><img  src="https://i.imgur.com/9dqDf5I.gif"/></div>

### 1. Các thư viện sử dụng trong ứng dụng:
- Về phía server sử dụng framework **Spring boot** để truyền tải dữ liệu restful webservice. Database sử dụng **MySql Workbench** để lưu trữ dữ liệu. 
- Về phía App thì được viết bằng ngôn ngữ java với các thư viện được sử dụng trong project như sau:
```xml
implementation 'androidx.appcompat:appcompat:1.2.0'
implementation 'com.squareup.retrofit2:retrofit:2.4.0'  
implementation 'com.squareup.retrofit2:converter-gson:2.2.0'  
implementation "androidx.recyclerview:recyclerview:1.1.0"  
implementation "androidx.cardview:cardview:1.0.0"  
implementation 'de.hdodenhof:circleimageview:3.1.0'  
implementation 'com.github.bumptech.glide:glide:4.11.0'  
implementation 'com.facebook.android:facebook-android-sdk:8.1.0'  
implementation 'com.google.android.gms:play-services-auth:19.0.0'
```
- Ứng dụng chạy trên `minSdkVersion 24`.

### 2. Các chức năng chính của ứng dụng:
- Sử dụng `Retrofit2` để truyền tải dữ liệu giữa server và app.
- Đăng kí đăng nhập bằng Facebook, Google, Server.
- Hiển thị danh sách các sản phẩm bằng custom view với Recyvleview (Tuỳ theo activity mà có các custom hiển thị khác nhau).
- Chức năng tìm kiếm, thêm sản phẩm vào giỏ hàng, viết bình luận và đánh giá cho sản phẩm, thanh toán sản phẩm.
- Ứng dụng sử dụng Shared Preferenced để lưu trữ thông tin phiên đăng nhập trên chính điện thoại.
- File database ứng dụng được đính kèm:
<div align="center"><img  src="https://i.imgur.com/e6yH0e5.png"/></div>