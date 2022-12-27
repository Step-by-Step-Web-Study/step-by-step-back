package com.stby.step.service;

import com.stby.step.dao.BulletinDAO;
import com.stby.step.dao.CommentDAO;
import com.stby.step.dto.bulletin.BulletinDTO;
import com.stby.step.dto.commentDTO.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;


@Service
public class BulletinService {


    @Autowired
    BulletinDAO bulletinDAO;



    public List<BulletinDTO> getList(BulletinDTO bulletinDTO, Model model){
        return bulletinDAO.getList(bulletinDTO);
    }

    public List<BulletinDTO> readBulletin(int bulletinId, Model model){
        return bulletinDAO.readBulletin(bulletinId);
    }

    public List<BulletinDTO> insertBulletin(){
        return bulletinDAO.insertBulletin();
    }

    public BulletinDTO insertwriteBulletin(BulletinDTO bulletinDTO, Principal principal){
        return bulletinDAO.insertwriteBulletin(bulletinDTO,principal);
    }

    public List<BulletinDTO> updateBulletin(int bulletinId, Model model){
        return bulletinDAO.updateBulletin(bulletinId,model);
    }

    public void Bulletin(BulletinDTO bulletinDTO){
        bulletinDAO.Bulletin(bulletinDTO);
    }

    public void deleteBulletin(int bulletinId){
        bulletinDAO.deleteBulletin(bulletinId);
    }

}