package com.example.ServerTsofen45.BL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ServerTsofen45.Beans.Support;
import com.example.ServerTsofen45.Repo.SupportRepository;


@Service
public class SupportBL {
	@Autowired
	SupportRepository supportRepository;
	
 /*   public boolean LogIn(Support support){
        Support byUserNme = supportRepository.findByUserName(support.getUserName());
        if (byUserNme!=null){
            return true;
        }
        return false;
    }
*/

	
        }
