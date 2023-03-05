package sg.edu.nus.iss.day22_workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day22_workshop.Utils;
import sg.edu.nus.iss.day22_workshop.models.TransferAccount;

@Service
public class LogAuditService {

    // @Autowired
    // RedisTemplate<String, Object> redisTemplate;

    // public int insertTransaction(TransferAccount ta){
    //     redisTemplate.opsForValue().set(ta.getId(), Utils.toJSON(ta).toString());
    //     String result = (String) redisTemplate.opsForValue().get(ta.getId());
    //     if(result != null){
    //         return 1;
    //     } else {
    //         return 0;
    //     }
    // }
    
}
