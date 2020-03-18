package com.springboot.data.reponsitory;

import com.springboot.data.entity.Effect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EffectReponsitory extends JpaRepository<Effect,String> {
}
