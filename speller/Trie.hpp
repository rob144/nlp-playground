#pragma once
#include "TrieNode.hpp"
#include <iostream>
#include <string.h>

using namespace std;

class Trie
{
public:
    static TrieNode* createTree()
    {
        return(new TrieNode('\0'));
    }
    static void insertWord(TrieNode root, string word)
    {
        int offset = 97;
        int l = word.length();
        char chars[word.size()+1];
        strcpy(chars, word.c_str());
        TrieNode curNode = root;
        
        for (int i = 0; i < l; i++)
        {
            if (curNode.links[chars[i]-offset].letter == '\0')
                curNode.links[chars[i]-offset].letter = chars[i];
            curNode = curNode.links[chars[i]-offset];
        }
        curNode.fullWord = true;  
    }
    static string printTrie(){
        return "TODO: PRINT TRIE\n";
    }

};
