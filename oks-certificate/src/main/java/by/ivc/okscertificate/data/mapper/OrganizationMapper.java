package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.Organization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizationMapper extends ReadMapper<Long, Organization> {}
