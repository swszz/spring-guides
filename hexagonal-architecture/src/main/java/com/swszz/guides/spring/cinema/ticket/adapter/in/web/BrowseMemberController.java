package com.swszz.guides.spring.cinema.ticket.adapter.in.web;

import com.swszz.guides.spring.cinema.ticket.application.port.in.BrowseMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : swszz
 */
@RestController
@RequiredArgsConstructor
public class BrowseMemberController {
    private final BrowseMemberUseCase browseMemberUseCase;
}
