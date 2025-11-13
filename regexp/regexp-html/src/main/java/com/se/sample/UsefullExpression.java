package com.se.sample;

public class UsefullExpression {

    private final static  String hyperLink = "<a\\b[^>]*href=\"([^\"]*)\"[^>]*>(.*?)<\\/a>";

/**
 * match all <div> tags in an HTML document
 * <div\b[^>]*>(.*?)<\/div>
 *     <div - начинается с <div
 *     \b   - конец слова ?
 *     [^>] - любой символ кроме >
 *     *    - 0 и более раз
 *     >    - должен идти єтот
 *     .    - любой символ
 *     *?   - ленивый 0 и более раз
  */

/**
 * Проверка открывающих и закрыва.щих тегов
 * <p>This is a paragraph.</p>
 * <a href="http://example.com">This is a link</a>
 *
 * <([a-z]+)([^<]+)*(?:>(.*)<\/\1>|\s+\/>)
 */

/**
 *  <([a-z]+)([^<]+)*(?:>(.*)<\/\1>|\s+\/>)
 *  <([a-z]+)(\s+[a-z-]+="[^"]*")*\s*>(.*?)<\/\1>
 * • <([a-z]+): Matches the opening tag name (e.g., div, a). *
 * • ([^<]+)* : Matches any attributes within the tag. *
 * • (?:>(.*)<\/\1>|\s+\/>): Matches the content between the opening and closing tags or self-closing tags.
 */


/**
 * Extracting all links
 * <a\b[^>]*href="([^"]*)"[^>]*>(.*?)<\/a>
 */

/**
 * Finding and content within tags
 * <p\b[^>]*>(.*?)<\/p>
 */

/**
 * (?=<[^>]+(?=[\s+\"\']btn[\s+\"\']).+)([^>]+>)
 * поиск строки в которой есть btn
 */

/**
 * <div.*class\s*=\s*["'].*the_class_you_require_here.*["']\s*>(.*)<\/div>
 *
 *     the_class_you_require_here - класс по которому ищем
 */

//////////////////////////////////////////////////////////////////////////////////////
   /*
   <div.*class\s*=\s*["'].*mainTag.*["']\s*>(.*)<\/div>
    */

}
