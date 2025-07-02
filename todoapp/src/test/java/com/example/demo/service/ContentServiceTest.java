package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Content;
import com.example.demo.model.SiteUser;
import com.example.demo.repository.ContentRepository;

@ExtendWith(MockitoExtension.class)
class ContentServiceTest {
    @Mock
    ContentRepository contentRepository;

    @InjectMocks
    ContentService contentService;

    @Test
    void search_noParams_returnsFindAll() {
        List<Content> expected = Collections.emptyList();
        when(contentRepository.findAll()).thenReturn(expected);

        List<Content> result = contentService.search("", "", null);

        verify(contentRepository).findAll();
        assertEquals(expected, result);
    }

    @Test
    void search_withSiteUserAndDeadline_returnsSiteUserAndDeadline() {
        SiteUser user = new SiteUser();
        List<Content> expected = Collections.emptyList();
        when(contentRepository.findBySiteUserAndDeadlineDate(user, "2021-01-01"))
                .thenReturn(expected);

        List<Content> result = contentService.search("", "2021-01-01", user);

        verify(contentRepository).findBySiteUserAndDeadlineDate(user, "2021-01-01");
        assertEquals(expected, result);
    }

    @Test
    void search_withTodoAndSiteUser_returnsTodoAndSiteUser() {
        SiteUser user = new SiteUser();
        List<Content> expected = Collections.emptyList();
        when(contentRepository.findByTodoLikeAndSiteUser("%task%", user))
                .thenReturn(expected);

        List<Content> result = contentService.search("task", "", user);

        verify(contentRepository).findByTodoLikeAndSiteUser("%task%", user);
        assertEquals(expected, result);
    }

    @Test
    void search_withTodoAndDeadline_returnsTodoAndDeadline() {
        List<Content> expected = Collections.emptyList();
        when(contentRepository.findByTodoLikeAndDeadlineDate("%task%", "2021-01-01"))
                .thenReturn(expected);

        List<Content> result = contentService.search("task", "2021-01-01", null);

        verify(contentRepository).findByTodoLikeAndDeadlineDate("%task%", "2021-01-01");
        assertEquals(expected, result);
    }

    @Test
    void search_withSiteUserOnly_returnsSiteUser() {
        SiteUser user = new SiteUser();
        List<Content> expected = Collections.emptyList();
        when(contentRepository.findBySiteUser(user)).thenReturn(expected);

        List<Content> result = contentService.search("", "", user);

        verify(contentRepository).findBySiteUser(user);
        assertEquals(expected, result);
    }

    @Test
    void search_withDeadlineOnly_returnsDeadline() {
        List<Content> expected = Collections.emptyList();
        when(contentRepository.findByDeadlineDate("2021-01-01")).thenReturn(expected);

        List<Content> result = contentService.search("", "2021-01-01", null);

        verify(contentRepository).findByDeadlineDate("2021-01-01");
        assertEquals(expected, result);
    }

    @Test
    void search_withTodoOnly_returnsTodo() {
        List<Content> expected = Collections.emptyList();
        when(contentRepository.findByTodoLike("%task%"))
                .thenReturn(expected);

        List<Content> result = contentService.search("task", "", null);

        verify(contentRepository).findByTodoLike("%task%");
        assertEquals(expected, result);
    }

    @Test
    void search_withAllParams_returnsTodoDeadlineSiteUser() {
        SiteUser user = new SiteUser();
        List<Content> expected = Collections.emptyList();
        when(contentRepository.findByTodoLikeAndDeadlineDateAndSiteUser("%task%", "2021-01-01", user))
                .thenReturn(expected);

        List<Content> result = contentService.search("task", "2021-01-01", user);

        verify(contentRepository).findByTodoLikeAndDeadlineDateAndSiteUser("%task%", "2021-01-01", user);
        assertEquals(expected, result);
    }
}
