package com.ostep.bookies.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class Blog {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String titleBlog,anonsBlog,fullTextBlog;
        private int views;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public Blog(String titleBlog, String anonsBlog, String fullTextBlog) {
            this.titleBlog = titleBlog;
            this.anonsBlog = anonsBlog;
            this.fullTextBlog = fullTextBlog;
        }

        public Blog() {
        }

        public String getTitleBlog() {
            return titleBlog;
        }

        public void setTitleBlog(String titleBlog) {
            this.titleBlog = titleBlog;
        }

        public String getAnonsBlog() {
            return anonsBlog;
        }

        public void setAnonsBlog(String anonsBlog) {
            this.anonsBlog = anonsBlog;
        }

        public String getFullTextBlog() {
            return fullTextBlog;
        }

        public void setFullTextBlog(String fullTextBlog) {
            this.fullTextBlog = fullTextBlog;
        }

    }
