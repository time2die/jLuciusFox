package com.time2java.ghb.init;

import com.time2java.ghb.dao.repo.KeyRepositary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by time2die on 17.03.16.
 */
@Configuration
@Profile("productive")
public class ProductiveProfile extends TestInit {
    public ProductiveProfile(ApplicationContext context, KeyRepositary keyRepositary) {
        super(context, keyRepositary);
    }
}
