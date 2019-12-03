/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setting;

/**
 *
 * @author Laptop88
 */
public class Query {
    public String querySyntax;    //cú pháp truy vấn
    public String queryDescription;  //mô tả truy vấn

    public Query(String queryDescription, String querySyntax) {
        this.queryDescription = queryDescription;
        this.querySyntax = querySyntax;
    }
}
