#pragma once
#include "TrieNode.hpp"
#include <iostream>
#include <string.h>

using namespace std;

class Trie
{

public:
    
    static TrieNode* createTree(){
        return(new TrieNode('\0'));
    }

    static void insertWord(TrieNode *ptr_root, char ptr_chars[])
    {
        int offset = 97;
        TrieNode *ptr_node = ptr_root;
        
        while(*ptr_chars){
            int index = *ptr_chars - offset;
            if (ptr_node->links[index] == NULL)
                ptr_node->links[index] = TrieNode (*ptr_chars[i]);
            ptr_node = ptr_node->links[index];
            ptr_chars++;
        }
        ptr_node->fullWord = true;  
    }
   
    static void printTrie(TrieNode *ptr_root){
        printTrieNode(ptr_root, 0, new char[50]);
    }

    static void printTrieNode(TrieNode *ptr_node, int level, char branch[]){
        if (ptr_node == NULL)
            return;
        
        TrieNode *links = ptr_node->links;
        while (){
            branch[level] = node.letter;
            printTree(node.links[i], level+1, branch);    
        }
        
        if (node.fullWord){
            string word = "";
            for (int j = 1; j <= level; j++)
                 word.append(1, branch[j]);
            cout << "WORD: " << word << "\n"; 
        }
    }

    static int numLinks(TrieNode linksArray[]){
        TrieNode tempNode ('a');
        return sizeof(linksArray) / sizeof(tempNode);
    }

};
