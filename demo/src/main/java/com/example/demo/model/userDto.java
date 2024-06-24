package com.example.demo.model;


import java.time.LocalDate;

// 入力チェックをするためのツールをインポートしています。
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class userDto {

    @NotNull
    private Integer id;

    @NotEmpty  // ユーザー名は空であってはならないというルール
    private String username;  // ユーザー名を保存するための場所

    @NotEmpty(message="パスワードを入力してください")  // パスワードは空であってはならないというルール
    private String password;  // パスワードを保存するための場所

    @NotEmpty  // メールアドレスは空であってはならないというルール
    private String email;  // メールアドレスを保存するための場所

    @NotEmpty  
    private LocalDate birthday;

    // 以下は各値を取得するためのメソッド（ゲッター）です。
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;  // ユーザー名を返す
    }
    
    public String getUsername() {
        return username;  // ユーザー名を返す
    }

    public void setUsername(String username) {
        this.username = username;  // ユーザー名を設定する
    }
    
    public String getEmail() {
        return email;  // メールアドレスを返す
    }
    
    public void setEmail(String email) {
        this.email = email;  // メールアドレスを設定する
    }

    public String getPassword() {
        return password;  // パスワードを返す
    }

    public void setPassword(String password) {
        this.password = password;  // パスワードを設定する
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
