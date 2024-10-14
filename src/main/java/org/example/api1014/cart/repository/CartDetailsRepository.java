package org.example.api1014.cart.repository;

import org.example.api1014.cart.domain.CartDetails;
import org.example.api1014.cart.dto.CartDetailsListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartDetailsRepository extends JpaRepository<CartDetails, Long> {
    @Query("""
       SELECT 
             new org.example.api1014.cart.dto.CartDetailsListDTO(
             p.pno,p.pname,p.price,count(r),attach.fileName,
             cd.qty
             )
       FROM 
          MemberEntity m 
          left join Cart c on c.member = m
          left join CartDetails cd on cd.cart = c
          join Product p on p = cd.product
          left join p.attachFiles attach
          left join Review r on r.product = p
       where m.email= :email
       and attach.ord = 0
       group by p
""")
    Page<CartDetailsListDTO> listofMember(@Param("email") String email, Pageable pageable);


}
