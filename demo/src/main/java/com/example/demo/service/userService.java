package com.example.demo.service;

//import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

//import java.util.Date;
// import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.user;
import com.example.demo.model.userDto;
import com.example.demo.repository.userRepository;

@Service
public class userService implements UserDetailsService {
    @Autowired // Springが自動的にUserRepositoryの実装を注入します
    private userRepository userRepository;

    @Autowired // Springが自動的にPasswordEncoderの実装を注入します
    private PasswordEncoder passwordEncoder;

    @Override // UserDetailsServiceインターフェースのメソッドを上書きします
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = userRepository.findByUsername(username); // ユーザー名でユーザーを検索します
        if (user == null) {
            throw new UsernameNotFoundException("User not found"); // ユーザーが見つからない場合、例外をスローします
        }
        return new userPrincipal(user); // ユーザーが見つかった場合、UserPrincipalを作成し返します
    }

    //新たにメソッドを追加します
    public user findByUsername(String username) {
        return userRepository.findByUsername(username); // ユーザー名でユーザーを検索し返します
    }

    @Transactional // トランザクションを開始します。メソッドが終了したらトランザクションがコミットされます。
    public void save(userDto userDto) {
        // UserDtoからUserへの変換
        user user = new user();
        user.setUsername(userDto.getUsername());
        // パスワードをハッシュ化してから保存
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setBirthday(userDto.getBirthday());

        // データベースへの保存
        userRepository.save(user); // UserRepositoryを使ってユーザーをデータベースに保存します
    }

    // public userDto getOnePass(Integer id) {
		
    //     // 更新対象のidを指定して本の情報を取得する
    //     user existingPass = userRepository.findById(id)/* .orElseThrow(() -> new EntityNotFoundException("user not found with id:" + id)) */;
		
    //     // 画面返却用のFormに値を設定する
    //     userDto userDto = new userDto();
    //     userDto.setId(existingPass.getId());
    //     userDto.setUsername(existingPass.getUsername());
    //     userDto.setPassword(existingPass.getPassword());
    //     userDto.setBirthday(existingPass.getBirthday());

    //     return userDto;
    // }

    // public void update(userDto userDto) {
		
    //     // データベースに登録する値を保持するインスタンスの作成
    //     user updateData = new user();
		
    //     // 画面から受け取った値を設定する
    //     updateData.setId(userDto.getId());
    //     updateData.setUsername(userDto.getUsername());
    //     updateData.setPassword(userDto.getPassword());
    //     updateData.setBirthday(userDto.getBirthday());
    //     // データベースを更新する
    //     userRepository.save(updateData);
    // }

    // //更新1
    // public user updatePass(Long id, user updatePass){
    //     //更新対象のnewpasswordを取得
    //     user existingPass = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found with id:" + id));
    //     //更新内容を設定
    //     existingPass.setPassword(updatePass.getPassword());
    //     //更新を保存
    //     return userRepository.save(existingPass);
    // }

    // 更新2
    // public boolean updatePassword(String username, String newPassword) {
    //     user user = userRepository.findByUsername(username); // ユーザー名でユーザーを検索します
    //     if (user.isPresent()) {
    //         user user = username.get();
    //         user.setPassword(newPassword); //userDtoにnewPasswordを作るべきか
    //         userRepository.save(user);
    //         return true;
    //     }
    //     return false;
    // }

    //resetPasswordTokenの値を設定し、変更をデータベースに保持
    // public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException {
    //     user user = userRepository.findByEmail(email);
    //     if (user != null) {
    //         user.setResetPasswordToken(token);
    //         userRepository.save(user);
    //     } else {
    //         throw new UsernameNotFoundException("Could not find any user with the email " + email);
    //     }
    // }
    // //指定されたパスワード・リセット・トークンでユーザーを検索
    // public user getByResetPasswordToken(String token) {
    //     return userRepository.findByResetPasswordToken(token);
    // }
    //  //新pass設定後パスワードのリセットトークンを無効
    // public void updatePassword(user user, String newPassword) {
    //     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //     String encodedPassword = passwordEncoder.encode(newPassword);
    //     user.setPassword(encodedPassword);
         
    //     user.setResetPasswordToken(null);
    //     userRepository.save(user);
    // }

}
