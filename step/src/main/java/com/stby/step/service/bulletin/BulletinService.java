package com.stby.step.service.bulletin;

import com.stby.step.dao.bulletin.BulletinDAO;
import com.stby.step.dto.bulletin.BulletinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BulletinService {

    @Autowired
    BulletinDAO bulletinDAO;

    public List<BulletinDTO> getList(BulletinDTO bulletinDTO){
        return bulletinDAO.getList(bulletinDTO);
    }

    public BulletinDTO readBulletin(int bulletinId){
        return bulletinDAO.readBulletin(bulletinId);
    }

    public List<BulletinDTO> insertBulletin(){
        return bulletinDAO.insertBulletin();
    }

    public void createBulletin(BulletinDTO bulletinDTO, String writer){
        bulletinDAO.createBulletin(bulletinDTO, writer);
    }

    public BulletinDTO updateBulletin(BulletinDTO bulletinDTO){
        return bulletinDAO.updateBulletin(bulletinDTO);
    }

    public void deleteBulletin(int bulletinId){
        bulletinDAO.deleteBulletin(bulletinId);
    }
}