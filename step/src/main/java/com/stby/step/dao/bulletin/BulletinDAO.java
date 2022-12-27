package com.stby.step.dao.bulletin;

import com.stby.step.dto.bulletin.BulletinDTO;
import com.stby.step.dto.commentDTO.CommentDTO;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@Repository
public class BulletinDAO {

    public static List<BulletinDTO> bulletin;
    public static BulletinDTO dto;

    public List<BulletinDTO> getList(BulletinDTO bulletinDTO){
        return bulletin;
    }

    public BulletinDTO readBulletin(int bulletinId){
        return dto;
    }

    public List<BulletinDTO> insertBulletin(){
        return bulletin;
    }

    public void createBulletin(BulletinDTO bulletinDTO, String writer){
        bulletin.add((BulletinDTO) bulletinDTO);
    }

    public BulletinDTO updateBulletin(BulletinDTO bulletinDTO){
        return dto;
    }

    public void deleteBulletin(int bulletinId){
        bulletin.stream();
    }
}
