package com.friendship41.memberauthserver.router

import com.friendship41.memberauthserver.handler.MemberHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router

@Configuration
class MemberRouter(private val memberHandler:MemberHandler) {
    @Bean
    fun routeMemberRequest() = nest(
            path("/member"),
            router {
                listOf(
                    GET("/test", memberHandler::testMember))
    })

    @Bean
    fun routeTestRequest() = nest(path("/"), router {
        listOf(GET("/", memberHandler::testMember))
    })
}
