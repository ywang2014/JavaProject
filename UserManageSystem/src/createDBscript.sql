DROP TABLE user;	# ɾ�����ܴ��ڵı��ٴ����±���ȫ��
CREATE TABLE user(
			id			INT				AUTO_INCREMENT PRIMARY KEY,
			name		VARCHAR(50)		NOT NULL,
			sex			VARCHAR(10)		NOT NULL,
			birthday	DATE
);