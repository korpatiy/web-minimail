package com.weblabs.lab3server.repo

import com.weblabs.lab3server.model.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface MessageRepository : JpaRepository<Message, Long> {

    @Transactional
    @Modifying
    @Query("update Message set clap = clap + 1 where id=:id")
    fun clapMessage(id: Long)
}