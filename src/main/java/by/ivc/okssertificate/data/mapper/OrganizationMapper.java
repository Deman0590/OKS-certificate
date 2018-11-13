package by.ivc.okssertificate.data.mapper;

import by.ivc.okssertificate.data.entity.Organization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMapper extends ReadMapper<Long, Organization> {}
