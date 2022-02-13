package com.alg.boot.webapi.apps.cms.snippets

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "snippets", path = "snippets")
interface SnippetRepository: JpaRepository<Snippet, Long>
