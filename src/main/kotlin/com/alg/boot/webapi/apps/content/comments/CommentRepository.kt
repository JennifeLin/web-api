package com.alg.boot.webapi.apps.content.comments

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long>
