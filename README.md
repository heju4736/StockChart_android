# StockChart_android
안드로이드 주식정보 어플리케이션



### 1. Prerequisites

- Android Studio 3.0.1
- Oracle Java SE Development Kit 8
- minSdkVersion 22 (Android 5.1 Lollipop 이상) / targetSdkVersion 26
- 카카오톡 자동로그인
  - build.gradle(app)
    ```Android
      compile group: 'com.kakao.sdk', name: 'kakaotalk', version: project.KAKAO_SDK_VERSION
    ```
  - build.gradle(Project)
    ```Android
     allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url 'http://devrepo.kakao.com:8088/nexus/content/groups/public/' }
        }
    }
    ```
  - gradle.properties(Project Properties)
    ```Android
       KAKAO_SDK_VERSION=1.7.1
    ```
- Firebase
  - build.gradle(app)
    ```Android
      compile 'com.google.firebase:firebase-messaging:11.6.2'
      apply plugin: 'com.google.gms.google-services'
    ```
  - build.gradle(Project)
    ```Android
      dependencies {
        classpath 'com.google.gms:google-services:3.1.1'                                           
      }
    ```
    
     
### 2. Installation Process

- Android Studio 3.0.0이상 다운
- 명시된 JDK 다운
- 명시된 SDK Version 다운
- NDK 다운
- Google Play Serveice compile 하기
- Push가 올 경우 화면이 켜지게 하기
  - AndroidManifest.xml
    ```Android
      <uses-permission android:name="android.permission.WAKE_LOCK" />
    ```
- Firebase에 프로젝트를 만들고 생성된 json파일을 Android Studio에 참조
  - AndroidManifest.xml
    ```Android
      <uses-permission android:name="android.permission.INTERNET" />
      <uses-permission android:name="android.permission.WAKE_LOCK" />
      
      <service
            android:name=".FirebaseMessagingService"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="com.google.firebase.MESSAGING_EVENT" />
            </intent-filter>
        </service>
        <service
            android:name=".FirebaseInstanceIDService"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="com.google.firebase.INSTANCE_ID_EVENT" />
            </intent-filter>
        </service>
    ```
- 카카오톡 key 추출 후 Kakao Develop에 만든 프로젝트와 연결
  - Debug Key
    ```Android
      keytool -exportcert -alias androiddebugkey -keystore C:\Users\Administrator.android\debug.keystore -storepass android -keypass android | openssl sha1 -binary | openssl base64
    ```
  - Release Key
    ```Android
      byte[] sha1 = {
                        0x3B, (byte)0xDA, (byte)0xA0, 0x5B, 0x4F, 0x35, 0x71, 0x02, 0x4E, 0x27, 0x22, (byte)0xB9, (byte)0xAc,
                        (byte)0xB2, 0x77, 0x2F, (byte)0x9D, (byte)0xA9, (byte)0x9B, (byte)0xD9 };
               
               Logger.e("keyHash: " + Base64.encodeToString(sha1, Base64.NO_WRAP));                                          
      }
    ```
 - 원형 ImageView를 사용하기 위해 Library 참조
   ```Android
     compile 'de.hdodenhof:circleimageview:2.2.0'
   ```
 - 앱을 실행하기 위해 필요한 권한 획득
  - AndroidManifest.xml
    ```Android
      <uses-permission android:name="android.permission.GET_ACCOUNTS" />
      <uses-permission android:name="android.permission.READ_PROFILE" />
      <uses-permission android:name="android.permission.READ_CONTACTS" />
      <uses-permission android:name="android.permission.READ_PHONE_STATE" />
      <uses-permission android:name="android.permission.READ_SMS" />
      <uses-permission android:name="android.permission.READ_CONTACTS" />
      <uses-permission android:name="android.permission.NFC" />
      <uses-permission android:name="android.permission.CAMERA" />
      <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
      <uses-permission android:name="android.permission.WAKE_LOCK" />
      <uses-feature android:name="android.hardware.nfc" android:required="false" />
      <uses-feature android:name="android.hardware.Camera" android:required="false" />
    ```
  

 
 ### 3. Getting Started
 
 - 회원가입 후 로그인 하거나 카카오톡 로그인을 사용하여 
 - 검색 버튼을 눌러 뜨는 새창에 종목 이름 검색후 눌러 사용
 
 
 ### 4. Known Issues & Troubleshooting
 
 - Ajax 호출 중복
 - 권한 획득으로 인한 기기호환 문제
 
 
 ### 5. screenshot
 
 
 ![팝콘차트](http://61.72.187.6/images/gitimage/popcorn1)
  ![팝콘차트](http://61.72.187.6/images/gitimage/popcorn2)
   ![팝콘차트](http://61.72.187.6/images/gitimage/popcorn3)
    ![팝콘차트](http://61.72.187.6/images/gitimage/popcorn4)
     ![팝콘차트](http://61.72.187.6/images/gitimage/popcorn5)
      
 
 
 ### 6. Copyright / End User License
 
 - 배희주 010-4736-9516
 
 ### 7. Change Log
 
 - 2018-04-30 기록을위해 커밋
 
 ### 8. Firebase Server 연동에 관한 Github로 이동
 
 - 아래를 클릭해주세요.

   [FirebasePushServer](https://github.com/heju4736/FirebasePushWebserver)
