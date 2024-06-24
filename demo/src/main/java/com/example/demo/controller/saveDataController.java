package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.saveData;
import com.example.demo.model.saveDto;
import com.example.demo.service.faceService;

import jakarta.transaction.Transactional;

@Controller
public class saveDataController {
    @Autowired
    private faceService faceService;

     @GetMapping("/save")//faceDataで出力した画像を保存する
    public String save(@ModelAttribute saveDto saveDto, Model model) {
        List<saveData> saveDataList = faceService.findAllSave();
        model.addAttribute("saveDataList", saveDataList);//画面に表示させる
        return "save";
    }

    // 削除
    @GetMapping("/delete")
    @Transactional
    public String delete(Model model, saveData saveData) {
        faceService.delete(saveData.getId());
       return "redirect:/save";
    }

    //更新
    @GetMapping("/saveEdit/{id}")
    public String editSaveData(@PathVariable("id") Long id, Model model, saveDto saveDto) {
    // List<saveData> saveDataList = faceService.findAllSave();
    // model.addAttribute("saveDataList", saveDataList);//画面に表示させる
    saveDto = faceService.getOneSaveData(saveDto.getId());
    model.addAttribute("saveDto",saveDto);
    return "/saveEdit";
    }

    // 更新データを保存
    @PostMapping("/saveEdit/{id}")
    public String updateSaveData(@PathVariable("id") Long id, saveDto saveDto) {
    faceService.update(saveDto);
        return "redirect:/save";
    }
}
