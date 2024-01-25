package com.nobroker.controller;

import com.itextpdf.text.DocumentException;
import com.nobroker.entity.User;
import com.nobroker.repository.UserRepository;
import com.nobroker.service.PDFGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/api/users")

public class PdfController {




        @Autowired
        private PDFGenerationService pdfGenerationService;

        @Autowired
        private UserRepository userRepository; // Assuming you have a repository for User entity

    //http://localhost:8080/api/users/downloadPDF

        @GetMapping("/downloadPDF")
        public ResponseEntity<byte[]> downloadPDF() throws DocumentException, UnsupportedEncodingException {
            List<User> users = userRepository.findAll(); // Fetch users from the database

            byte[] pdfBytes = pdfGenerationService.generatePDF(users);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", URLEncoder.encode("report.pdf", "UTF-8"));

            return ResponseEntity.ok().headers(headers).body(pdfBytes);
        }
    }

