package com.doublevpartners.doublev_partners_tickets.application.search;

import static org.mockito.ArgumentMatchers.any;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

import com.doublevpartners.doublev_partners_tickets.domain.PageAsk;
import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.TicketFilter;
import com.doublevpartners.doublev_partners_tickets.domain.port.search.TicketSearcherRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TicketSearcherTest {

    @Mock
    private TicketSearcherRepository ticketSearcherRepository;

    @InjectMocks
    private TicketSearcher ticketSearcher;


    @Test
    public void whenFindTicket_GivenValidParameters_ThenReturnListResultnew() {

        Mockito.lenient().when(ticketSearcherRepository.searchAll(any(), any()))
                .thenReturn(streamSupplier(buildTicket()));

        EasyRandom easyRandom = new EasyRandom();
        TicketFilter ticketFilter = easyRandom.nextObject(TicketFilter.class);

        Supplier<Stream<Ticket>> result = ticketSearcher.searchAll(ticketFilter, PageAsk.create(0, 100));

        Long actualValue = 5L;
        Assertions.assertEquals(actualValue, result.get().count());

    }

    public Supplier<Stream<Ticket>> streamSupplier(Stream<Ticket> ticketStream) {
        return () -> {
            Iterator<Ticket> iterator = ticketStream.iterator();
            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
        };
    }

    private Stream<Ticket> buildTicket() {
        EasyRandom easyRandom = new EasyRandom();
        return easyRandom.objects(Ticket.class, 5);
    }

}
