package com.arktekk.littlebro

import java.io.InputStream
import xml.parsing.NoBindingFactoryAdapter
import xml.{TopScope, Node}

/**
 * @author Thor Åge Eldby (thoraageeldby@gmail.com)
 */
object XmlParser extends NoBindingFactoryAdapter {
  private val namespacePrefixes = "http://xml.org/sax/features/namespace-prefixes"
  val parserFactory = javax.xml.parsers.SAXParserFactory.newInstance()
  parserFactory.setNamespaceAware(false)
  parserFactory.setFeature(namespacePrefixes, true)
  val parser = parserFactory.newSAXParser

  def loadXML(inputStream: InputStream): Node = {
    scopeStack.push(TopScope)
    parser.parse(inputStream, this)
    scopeStack.pop
    rootElem
  }

}
