package com.arktekk.littlebro

import xml.{NodeSeq, Node}

/**
 * @author Thor Åge Eldby (thoraageeldby@gmail.com)
 */

object XmlHelper {
  class NodeSeqWrapper(nodeSeq: NodeSeq) {
    def filterClass(className: String): Seq[Node] = nodeSeq.filter({node => (node \ "@class").text == className})
  }
  implicit def wrapNodeSeq(nodeSeq: NodeSeq) = new NodeSeqWrapper(nodeSeq)
}
