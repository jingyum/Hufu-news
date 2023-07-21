package generator.service;

import generator.domain.Interfaces;

public interface TPService {
    void get_catch(Interfaces iface, String keyword, int dayToFetch);
    void forKeyword(String keyword);
}
