package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.controller.search;

import com.doublevpartners.doublev_partners_tickets.application.search.TicketSearcher;
import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.mapper.TicketRestMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TicketSearcherControllerTest {

    private static final String TICKET_PATH = "/tickets";

    @Mock
    private TicketSearcher ticketSearcher;

    @Mock
    private TicketRestMapper ticketRestMapper;

    @InjectMocks
    private TicketSearchController ticketSearchController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ticketSearchController).build();
    }

    @Test
    public void whenFindTicket_GivenValidParameters_ThenReturnListResult() throws Exception {

        final Page<Ticket> page = new PageImpl<>(Collections.emptyList(),
                PageRequest.of(0, 5), 0);

        Mockito.lenient().when(ticketSearcher.searchAll(any(), any())).thenReturn(
                page);

        mockMvc.perform(get(TICKET_PATH)
                        .param("initialDate", "2024-08-01")
                        .param("finalDate", "2024-08-10")
                        .param("pageNumParam", "0")
                        .param("pageSizeParam", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", Matchers.hasSize(0)));
    }
}
