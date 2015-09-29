package my_abc_onlineBookStore;

import org.neo4j.graphdb.RelationshipType;
public enum neo4jRelationships implements RelationshipType{
	INVOICE_COLLECT_BOOK,SHOW_INVOICE;
}