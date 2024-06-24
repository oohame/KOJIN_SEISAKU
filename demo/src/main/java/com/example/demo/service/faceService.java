package com.example.demo.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.faceData;
import com.example.demo.model.menBody;
import com.example.demo.model.saveData;
import com.example.demo.model.saveDto;
import com.example.demo.repository.faceDataRepository;
import com.example.demo.repository.imageRepository;
import com.example.demo.repository.saveDataRepository;

// import jakarta.transaction.Transactional;

@Service
public class faceService {
    @Autowired
    private  faceDataRepository faceDataRepository;

    @Autowired
    private  imageRepository imageRepository;

    @Autowired
    private saveDataRepository saveDataRepository;



    // 全件検索
    public List<faceData> findAll() {
        List<faceData> faceDataList = faceDataRepository.findAll();
        return faceDataList;
    }

    //検索
    public List<faceData> searchByUsernameFaceDatas(String username/*, String phonetic*/) {
        List<faceData> faceDataList;
        if (username == null || username.isEmpty()) {
            faceDataList = faceDataRepository.findAll();
        } else {
            faceDataList = faceDataRepository.findByUsernameContaining(username);
        }
        return faceDataList;
    }

    //IDを見つける
    public faceData findFaceSkinById(Long id){
        return faceDataRepository.findById(id).orElse(null);//後で調べる
    }

    //データベースを表示
    public List<menBody> findAllImage() {
        List<menBody> imageBodyList = imageRepository.findAll();
        return imageBodyList;
    }

   //保存
    public void save(saveDto saveDto) {

        saveData saveData = new saveData();
        saveData.setFace_save(saveDto.getFace_save());
        saveData.setBody_save(saveDto.getBody_save());
        saveData.setTitle(saveDto.getTitle());
        saveDataRepository.save(saveData);
    }

    //セーブデータを表示
    public List<saveData> findAllSave() {
        List<saveData> SaveDataList = saveDataRepository.findAll();
        return SaveDataList;
    }

    //削除
    public void delete(Long id) {
        // idを指定して、データベースからデータを削除する
        saveDataRepository.deleteById(id);
    }


    //更新
public saveDto getOneSaveData(Long id) {
		
    // idを指定
    saveData saveData = saveDataRepository.findById(id).orElseThrow();
		
    // 画面返却用のFormに値を設定する
    saveDto saveDto = new saveDto();
    saveDto.setId(saveData.getId());
    saveDto.setFace_save(saveData.getFace_save());
    saveDto.setBody_save(saveData.getBody_save());
    saveDto.setTitle(saveData.getTitle());
		
    return saveDto;
}

public void update(saveDto saveDto) {

    saveData saveData = new saveData();

    saveData.setId(saveDto.getId());
    saveData.setFace_save(saveDto.getFace_save());
    saveData.setBody_save(saveDto.getBody_save());
    saveData.setTitle(saveDto.getTitle());

    saveDataRepository.save(saveData);
}


}



