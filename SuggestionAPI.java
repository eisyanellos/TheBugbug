package slms;

/**
 * Project: Student Learning Management System (SLMS)
 * Author: NUR BATRISYIA AZUHAIMI && NIK MUHAMMAD AIRIEL
 * Description: Responsible for system integration, middleware API,and relationship management logic.
 */

import java.util.*;

public class SuggestionAPI {
    
    // Lab 8: API Logic
    public static List<String> getSuggestions(String input) {
        List<String> matches = new ArrayList<>();
        String search = input.toLowerCase();
        
        for (String name : StudentSystem.studentCache) {
            if (name.startsWith(search)) {
                matches.add(name);
            }
        }
        return matches;
    }
}