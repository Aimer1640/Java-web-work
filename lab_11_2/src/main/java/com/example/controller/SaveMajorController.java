package com.example.controller;

import com.example.pojo.Major;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveMajorController extends AbstractController {
    //    2040706101 杨艾琳
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Major major=new Major();
        major.setMajorId(request.getParameter("majorId"));
        major.setMajorName(request.getParameter("majorName"));
        major.setTuition(Integer.parseInt(request.getParameter("tuition")));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("major",major);
        modelAndView.setViewName("majorInfo");
        return modelAndView;
    }
}
