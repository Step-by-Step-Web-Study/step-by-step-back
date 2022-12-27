package com.stby.step.dao;

import com.stby.step.dto.bulletin.BulletinDTO;
import com.stby.step.dto.commentDTO.CommentDTO;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@Repository
public class BulletinDAO {

    public static List<BulletinDTO> bulletin;

    public List<BulletinDTO> getList(BulletinDTO bulletinDTO){
        return bulletin;
    }

    public List<BulletinDTO> readBulletin(int bulletinId){
        return bulletin;
    }

    public List<BulletinDTO> insertBulletin(){
        return bulletin;
    }

    public BulletinDTO insertwriteBulletin(BulletinDTO bulletinDTO, Principal principal){
        bulletin.add((BulletinDTO) principal);
        return bulletinDTO;
    }

    public List<BulletinDTO> updateBulletin(int bulletinId, Model model){
        return bulletin;
    }
    public void Bulletin(BulletinDTO bulletinDTO){
        bulletin.stream();
    }

    public void deleteBulletin(int bulletinId){
        bulletin.stream();
    }
}
