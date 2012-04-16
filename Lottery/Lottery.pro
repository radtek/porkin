#-------------------------------------------------
#
# Project created by QtCreator 2012-04-17T00:25:59
#
#-------------------------------------------------

QT       += core

QT       -= gui

TARGET = Lottery
CONFIG   += console
CONFIG   -= app_bundle

TEMPLATE = app


SOURCES += main.cpp \
    sqlite3.c \
    resultitem.cpp \
    lottery.cpp \
    CppSQLite3.cpp \
    ball.cpp

HEADERS += \
    sqlite3.h \
    resultitem.h \
    lottery.h \
    CppSQLite3.h \
    constants.h \
    caculation.h \
    ballutils.h \
    ball.h
