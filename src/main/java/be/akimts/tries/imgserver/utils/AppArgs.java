package be.akimts.tries.imgserver.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import java.util.List;

@Component
public class AppArgs {

    private final MultiValueMap<String, String> argsMap;

    public AppArgs(ApplicationArguments args) {
        this.argsMap = toArgsMap(args);
    }

    public boolean contains(String arg) {
        return argsMap.containsKey(arg);
    }

    public List<String> get(String arg){
        return argsMap.get(arg);
    }

    public String getFirst(String arg){
        return argsMap.getFirst(arg);
    }

    private MultiValueMap<String, String> toArgsMap(ApplicationArguments args){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        for (String arg : args.getOptionNames()){
            map.put(arg, args.getOptionValues(arg));
        }
        return map;
    }
}
