package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.faceData;
import com.example.demo.model.menBody;
import com.example.demo.model.saveData;
import com.example.demo.model.saveDto;
import com.example.demo.service.faceService;

import jakarta.validation.Valid;

@Controller
public class searchInputController {

    @Autowired
    private faceService faceService;

    @GetMapping("/index")
	public String getDataList(Model model) {

        List<faceData> faceDataList = faceService.findAll();
        model.addAttribute("faceDataList", faceDataList);//画面に表示させる
	return "/index";
    }   

    @PostMapping("/index")
	public String getSelectList(Model model,  @RequestParam("username") String username/* , RedirectAttributes redirectAttributes */) {

        //model.addAttribute("msg", "検索結果");
        // RedirectAttributes faceDataList = redirectAttributes.addFlashAttribute("username", username);
        // model.addAttribute("faceDataList", faceDataList);//画面に表示させる

        List<faceData> faceDataList = faceService.searchByUsernameFaceDatas(username);
            model.addAttribute("faceDataList", faceDataList);
            return "/index";
    }   

    //編集画面
    @GetMapping("index/edit/{id}")
    public String showFaceSkin(@PathVariable("id") Long id, Model model, menBody menBody) {
        //顔を表示
        faceData faceData = faceService.findFaceSkinById(id);
        model.addAttribute("faceData", faceData);

        //身体一覧の表示　faceServiceに記述している
        List<menBody> menBodyList = faceService.findAllImage();
        model.addAttribute("menBodyList", menBodyList);

        // 新しいsaveDtoオブジェクトを"saveData"という名前で追加
        model.addAttribute("saveData", new saveDto()); 
        return "edit";
    }   

    @PostMapping("/save")//faceDataで出力した画像を保存する
    public String save(@Valid @ModelAttribute saveDto saveDto, BindingResult bindingResult, Model model) {
        // if (bindingResult.hasErrors()) {
        //     model.addAttribute("errorMessage", "身体を選択してください");
        //     return "redirect:index/edit/1";
        // }
            //保存処理
            faceService.save(saveDto);
            //保存画面へ遷移
            List<saveData> saveDataList = faceService.findAllSave();
            model.addAttribute("saveDataList", saveDataList);//画面に表示させる
            return "save";
        
    }
}
